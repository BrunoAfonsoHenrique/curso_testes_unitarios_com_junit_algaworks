package com.algaworks.junit.blog.negocio;


import com.algaworks.junit.blog.armazenamento.ArmazenamentoEditor;
import com.algaworks.junit.blog.modelo.Editor;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class) // Para funcionar os @Mock
class CadastroEditorComMockTest {

    @InjectMocks
    CadastroEditor cadastroEditor;
    Editor editor;

    @Mock
    ArmazenamentoEditor armazenamentoEditor;
    @Mock
    GerenciadorEnvioEmail gerenciadorEnvioEmail;

    @BeforeEach
    void beforeEach() {
        editor = new Editor(null, "Alex", "alex@email.com", BigDecimal.TEN, true);

//        ArmazenamentoEditor armazenamentoEditor = Mockito.mock(ArmazenamentoEditor.class);
//        GerenciadorEnvioEmail gerenciadorDeEmail = Mockito.mock(GerenciadorEnvioEmail.class);

        Mockito.when(armazenamentoEditor.salvar(editor))
                .thenReturn(new Editor(1L, "Alex", "alex@email.com", BigDecimal.TEN, true));
        
    }

    @Test
    void Dado_um_editor_valido_quando_criar_entao_deve_retornar_um_id_de_cadastro() {
        Editor editorSalvo = cadastroEditor.criar(editor);
        Assertions.assertEquals(1L, editorSalvo.getId());

    }
}