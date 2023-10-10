package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.exception.RegraNegocioException;
import com.algaworks.junit.blog.modelo.Editor;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CadastroEditorTest {

    CadastroEditor cadastroEditor;
    ArmazenamentoEditorEmMemoria armazenamentoEditor;
    Editor editor;


    @BeforeEach
    void beforeEach() {
        editor = new Editor(null, "Alex", "alex@email.com", BigDecimal.TEN, true);

        armazenamentoEditor = new ArmazenamentoEditorEmMemoria();
        cadastroEditor = new CadastroEditor(
                armazenamentoEditor,
                new GerenciadorEnvioEmail() {
                    @Override
                    void enviarEmail(Mensagem mensagem) {
                        System.out.println("Enviando mensagem par: " + mensagem.getDestinatario());
                    }
                }
        );
    }

    @Test
    void Dado_um_editor_valido_quando_criar_entao_deve_retornar_um_id_de_cadastro() {
        Editor editorSalvo = cadastroEditor.criar(editor);
        Assertions.assertEquals(1L, editorSalvo.getId());
        Assertions.assertTrue(armazenamentoEditor.chamouSalvar);
    }


    @Test
    public void Dado_um_editor_null_Quando_criar_Entao_deve_retornar_um_id_de_cadastro2() {
        Assertions.assertThrows(NullPointerException.class, () -> cadastroEditor.criar(null));
        Assertions.assertFalse(armazenamentoEditor.chamouSalvar);
    }

    @Test
    public void Dado_um_editor_editor_com_email_existente_Quando_criar_Entao_deve_lancar_exception() {
        editor.setEmail("alex.existe@email.com");
        assertThrows(RegraNegocioException.class, () -> cadastroEditor.criar(editor));
        assertFalse(armazenamentoEditor.chamouSalvar);
    }
}