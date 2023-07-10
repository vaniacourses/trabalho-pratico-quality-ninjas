package view;

import model.Pokemon;
import model.Treinador;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JDialogVinculacaoDePokemonTest {

    private JDialogVinculacaoDePokemon dialog;

    @Before
    public void setUp() {
        Treinador james = new Treinador(1, "James", "Unova");
        dialog = new JDialogVinculacaoDePokemon(null, james);
        dialog.initComponents();
    }

    @Test
    public void testAdd() {
        // Simulando a seleção  e adição de um Pokemon na ComboBox

        dialog.jComboBoxPokemons.setSelectedIndex(0);
        dialog.add();

        // Verificando se o Pokémon foi removido da lista de pokémons e adicionado à lista de pokémons vinculados
        assertEquals(1, dialog.listaDePokemons.size());
        assertEquals(1, dialog.pokemons.size());
    }

    @Test
    public void testSalvar() {
        // Adicionando um Pokémon à lista de pokémons vinculados
        model.Pokemon pokemon = new model.Pokemon(1, "Pikachu", "Elétrico", "Nenhum", 35, 55, 40, 50, 50, 90, 1, 1, false, .4F, 6);
        dialog.listaDePokemons.add(pokemon);

        assertTrue(dialog.salvar());
    }

    @Test
    public void testAtualizarTabelaPokemon() {
        // Criando uma lista de pokémons fictícia para teste
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new model.Pokemon(1, "Pikachu", "Elétrico", "Puro", 35, 55, 40, 50, 50, 90, 1, 1, false, 0.4F, 6));
        pokemons.add(new model.Pokemon(2, "Bulbasaur", "Planta", "Venenoso", 45, 49, 49, 65, 65, 45, 1, 1, false, 0.7F, 6.9F));
        pokemons.add(new model.Pokemon(3, "Charizard", "Fogo", "Voador", 78, 84, 78, 109, 85, 100, 1, 1, false, 1.7F, 90.5F));

        // Chama o método atualizarTabelaPokemon
        dialog.atualizarTabelaPokemon(pokemons);

        // Verifica se a tabela foi preenchida corretamente
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) dialog.jTablePokemons.getModel();
        assertEquals(3, model.getRowCount());
        assertEquals(4, model.getColumnCount());
        assertEquals("ID", model.getColumnName(0));
        assertEquals("NOME", model.getColumnName(1));
        assertEquals("TIPO 1", model.getColumnName(2));
        assertEquals("TIPO 2", model.getColumnName(3));
        assertEquals("1", model.getValueAt(0, 0));
        assertEquals("Pikachu", model.getValueAt(0, 1));
        assertEquals("Elétrico", model.getValueAt(0, 2));
        assertEquals("Puro", model.getValueAt(0, 3));
        assertEquals("2", model.getValueAt(1, 0));
        assertEquals("Bulbasaur", model.getValueAt(1, 1));
        assertEquals("Planta", model.getValueAt(1, 2));
        assertEquals("Venenoso", model.getValueAt(1,3));
        assertEquals("3", model.getValueAt(2, 0));
        assertEquals("Charizard", model.getValueAt(2, 1));
        assertEquals("Fogo", model.getValueAt(2, 2));
        assertEquals("Voador", model.getValueAt(2, 3));
    }
    @Test
    public void testListar() {
        dialog.initComponents();
        // Criando uma lista de pokémons fictícia para teste
        ArrayList<model.Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new model.Pokemon(1, "Pikachu", "Elétrico", "Puro", 35, 55, 40, 50, 50, 90, 1, 1, false, 0.4F, 6));
        pokemons.add(new model.Pokemon(2, "Bulbasaur", "Planta", "Venenoso", 45, 49, 49, 65, 65, 45, 1, 1, false, 0.7F, 6.9F));
        pokemons.add(new model.Pokemon(3, "Charizard", "Fogo", "Voador", 78, 84, 78, 109, 85, 100, 1, 1, false, 1.7F, 90.5F));

        // Chama o método listar
        dialog.listar(pokemons);

        // Verifica se o JCombobox foi preenchido corretamente

        assertThat(dialog.jComboBoxPokemons.getItemCount()).isEqualTo(3);
        assertThat(dialog.jComboBoxPokemons.getItemAt(0)).isEqualTo("Pikachu");
        assertThat(dialog.jComboBoxPokemons.getItemAt(1)).isEqualTo("Bulbasaur");
        assertThat(dialog.jComboBoxPokemons.getItemAt(2)).isEqualTo("Charizard");
    }

}