package br.jus.tse.judiciaria.mural.dao.usuario;

import br.jus.tse.judiciaria.mural.dao.UsuarioDAOImpl;
import br.jus.tse.judiciaria.mural.entidade.Usuario;
import br.jus.tse.corporativa.exception.DAOException;
import br.jus.tse.corporativa.teste.AbstractDAOTest;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author solimar.alves
 */
public class UsuarioDAOImplTest extends AbstractDAOTest {

    private UsuarioDAOImpl usuarioDAO;

    @Override
    public void before() {
        usuarioDAO = new UsuarioDAOImpl();
        usuarioDAO.setEntityManager(super.getEm());
    }

    @Override
    public void after() {
    }

    @Test
    public void testInsert() throws Exception {
        final Usuario entity = new Usuario();
        entity.setNome("Solimar Alves dos Santos");
        entity.setEmail("solimar.alves@tse.jus.br");
        entity.setNascimento(new Date());
        entity.setSenha("123456");
        super.getEm().getTransaction().begin();
        this.usuarioDAO.salvar(entity);
        super.getEm().getTransaction().commit();
        final Usuario result = this.usuarioDAO.recuperarPeloId(entity.getId());
        Assert.assertEquals("Solimar Alves dos Santos", result.getNome());
    }

    @Test
    public void testExcluir() throws Exception {
        final Usuario entity = new Usuario();
        entity.setNome("Exclusao");
        entity.setEmail("solimar.alves@tse.jus.br");
        entity.setNascimento(new Date());
        entity.setSenha("123456");
        super.getEm().getTransaction().begin();
        this.usuarioDAO.salvar(entity);
        super.getEm().getTransaction().commit();
        final Usuario entitdadeIncluida = this.usuarioDAO.recuperarPeloId(1L);
        try {
            this.usuarioDAO.excluir(entitdadeIncluida);
        } catch (final DAOException ex) {
            Logger.getLogger(UsuarioDAOImplTest.class.getName()).log(Level.SEVERE, null, ex);
            Assert.fail(ex.getMessage());
        }
        final Usuario entidadeExcluida = this.usuarioDAO.recuperarPeloId(1L);
        Assert.assertNull(entidadeExcluida);
    }

    @Test
    public void testAtualizar() {
        final Usuario entity = new Usuario();
        entity.setNome("Exclusao");
        entity.setEmail("solimar.alves@tse.jus.br");
        entity.setNascimento(new Date());
        entity.setSenha("123456");
        super.getEm().getTransaction().begin();
        this.usuarioDAO.salvar(entity);
        super.getEm().getTransaction().commit();
        entity.setNome("Solimar Alves dos Santos");
        this.usuarioDAO.atualizar(entity);

        final Usuario entidadeAtualizada = this.usuarioDAO.recuperarPeloId(1L);
        Assert.assertEquals("Solimar Alves dos Santos", entidadeAtualizada.getNome());
    }

    @Test
    public void testConsultarTodos() {
        final int qtdeRegistrosAIncluir = 6;
        this.inserir(qtdeRegistrosAIncluir);
        final List<Usuario> registros = this.usuarioDAO.findAll();
        Assert.assertEquals(qtdeRegistrosAIncluir, registros.size());
    }

    @Test
    public void testConsultarPaginado() {
        final int qtdeRegistrosAIncluir = 6;
        this.inserir(qtdeRegistrosAIncluir);
        final Integer paginaAtual = 0;
        final Integer registrosPorPagina = 5;
        final List<Usuario> registros = this.usuarioDAO.findAll(paginaAtual, registrosPorPagina);
        Assert.assertEquals(registrosPorPagina, Integer.valueOf(registros.size()));
    }

    private void inserir(int qtdRegistro) {
        Usuario entity;
        super.getEm().getTransaction().begin();
        for (int i = 0; i < qtdRegistro; i++) {
            entity = new Usuario();
            entity.setNome("Solimar" + i);
            entity.setEmail("solimar.alves@tse.jus.br");
            entity.setNascimento(new Date());
            entity.setSenha("123456");
            this.usuarioDAO.salvar(entity);
        }
        super.getEm().getTransaction().commit();
    }
}
