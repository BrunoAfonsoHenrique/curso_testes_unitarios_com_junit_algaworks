package com.algaworks.junit.blog.negocio;


import com.algaworks.junit.blog.armazenamento.ArmazenamentoEditor;
import com.algaworks.junit.blog.exception.RegraNegocioException;
import com.algaworks.junit.blog.modelo.Editor;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class) // Para funcionar os @Mock
class CadastroEditorComMockTest {

    @InjectMocks
    CadastroEditor cadastroEditor;

    @Spy
    Editor editor = new Editor(null, "Alex", "alex@email.com", BigDecimal.TEN, true);

    @Mock
    ArmazenamentoEditor armazenamentoEditor;
    @Mock
    GerenciadorEnvioEmail gerenciadorEnvioEmail;
    @Captor
    ArgumentCaptor<Mensagem> mensagemArgumentCaptor;

    @Nested
    class CadastroComEditarValido {
        @BeforeEach
        void beforeEach() {
            // editor = new Editor(null, "Alex", "alex@email.com", BigDecimal.TEN, true);
            Mockito.when(armazenamentoEditor.salvar(Mockito.any(Editor.class)))
                    .thenAnswer(invocacao -> {
                        Editor editorPassado = invocacao.getArgument(0, Editor.class);
                        editorPassado.setId(1L);
                        return editorPassado;
                    });

        }

        @Test
        void Dado_um_editor_valido_quando_criar_entao_deve_retornar_um_id_de_cadastro() {
            Editor editorSalvo = cadastroEditor.criar(editor);
            Assertions.assertEquals(1L, editorSalvo.getId());

        }

        // Verificar se um método realmente está sendo chamado
        @Test
        void Dado_um_editor_valido_Quando_criar_Entao_deve_chamar_metodo_salvar() {
            cadastroEditor.criar(editor);
            Mockito.verify(armazenamentoEditor, Mockito.times(1))
                    .salvar(Mockito.eq(editor));
        }

//    @Test
//    void Dado_um_editor_valido_quando_criar_lancar_exception_ao_salvar_entao_nao_deve_enviar_email() {
//        //Mockito.when(armazenamentoEditor.salvar(Mockito.any())).thenThrow(new RuntimeException());
//        Mockito.when(armazenamentoEditor.salvar(editor)).thenThrow(new RuntimeException());
//        Assertions.assertThrows(RuntimeException.class, () -> cadastroEditor.criar(editor));
//        Mockito.verify(gerenciadorEnvioEmail, Mockito.never()).enviarEmail(Mockito.any());
//    }

        @Test
        void Dado_um_editor_valido_Quando_criar_e_lancar_exception_ao_salvar_Entao_nao_deve_enviar_email() {
            Mockito.when(armazenamentoEditor.salvar(editor)).thenThrow(new RuntimeException());
            Assertions.assertAll("Não deve enviar e-mail, quando lançar Exception do armazenamento",
                    ()->Assertions.assertThrows(RuntimeException.class, ()-> cadastroEditor.criar(editor)),
                    ()->Mockito.verify(gerenciadorEnvioEmail, Mockito.never()).enviarEmail(Mockito.any())
            );
        }

    /*
    @Test
    void Dado_um_editor_valido_Quando_cadastrar_Entao_deve_enviar_email_com_destino_ao_editor() {
        ArgumentCaptor<Mensagem> mensagemArgumentCaptor = ArgumentCaptor.forClass(Mensagem.class);
        Editor editorSalvo = cadastroEditor.criar(editor);
        Mockito.verify(gerenciadorEnvioEmail).enviarEmail(mensagemArgumentCaptor.capture());
        Mensagem mensagemPassada = mensagemArgumentCaptor.getValue();
        Assertions.assertEquals(editorSalvo.getEmail(), mensagemPassada.getDestinatario());

    }

     */

        @Test
        void Dado_um_editor_valido_Quando_cadastrar_Entao_deve_enviar_email_com_destino_ao_editor() {
            Editor editorSalvo = cadastroEditor.criar(editor);
            Mockito.verify(gerenciadorEnvioEmail).enviarEmail(mensagemArgumentCaptor.capture());
            Mensagem mensagemPassada = mensagemArgumentCaptor.getValue();
            Assertions.assertEquals(editorSalvo.getEmail(), mensagemPassada.getDestinatario());

        }

        @Test
        void Dado_um_editor_valido_Quando_cadastrar_Entao_deve_verificar_o_email() {
            Editor editorSpy = Mockito.spy(editor);
            cadastroEditor.criar(editorSpy);
            Mockito.verify(editorSpy, Mockito.atLeast(1)).getEmail();

        }

        @Test
        void Dado_um_editor_com_email_existente_Quando_cadastrar_Entao_deve_lancar_exception() {
            Mockito.when(armazenamentoEditor.encontrarPorEmail("alex@email.com"))
                    .thenReturn(Optional.empty())
                    .thenReturn(Optional.of(editor));
            Editor editorComEmailExistente = new Editor(null, "Alex", "alex@email.com", BigDecimal.TEN, true);
            cadastroEditor.criar(editor);
            Assertions.assertThrows(RegraNegocioException.class, () -> cadastroEditor.criar(editorComEmailExistente));
        }

        @Test
        void Dado_um_editor_valido_Quando_cadastrar_Entao_deve_enviar_email_apos_salvar() {
            cadastroEditor.criar(editor);

            InOrder inOrder = Mockito.inOrder(armazenamentoEditor, gerenciadorEnvioEmail);
            inOrder.verify(armazenamentoEditor, Mockito.times(1)).salvar(editor);
            inOrder.verify(gerenciadorEnvioEmail, Mockito.times(1))
                    .enviarEmail(Mockito.any(Mensagem.class));

        }
    }

    @Nested
    class CadastroComEditorNull {
        @Test
        void Dado_um_editor_null_Quando_cadastrar_Entao_deve_lancar_exception() {
            Assertions.assertThrows(NullPointerException.class, () -> cadastroEditor.criar(null));
            Mockito.verify(armazenamentoEditor, Mockito.never()).salvar(Mockito.any());
            Mockito.verify(gerenciadorEnvioEmail, Mockito.never()).enviarEmail(Mockito.any());
        }
    }


}