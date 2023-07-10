//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package view;

import model.Pokemon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.table.TableModel;
import java.util.ArrayList;

public class JanelaPrincipalTest {
    private JanelaPrincipal janelaPrincipal;
    private ArrayList<Pokemon> pokemons;

    public JanelaPrincipalTest() {
    }

    @BeforeEach
    public void setUp() {
        this.janelaPrincipal = new JanelaPrincipal();
        this.pokemons = new ArrayList();
        this.pokemons.add(new Pokemon(1, "Bulbasaur", "Grass", "Poison"));
        this.pokemons.add(new Pokemon(2, "Charmander", "Fire", ""));
        this.pokemons.add(new Pokemon(3, "Squirtle", "Water", ""));
    }

    @Test
    public void testAtualizarTabelaPokemon() {
        TableModel modeloAtualizado = this.janelaPrincipal.atualizarTabelaPokemon(pokemons);
        Assertions.assertEquals(3, modeloAtualizado.getRowCount());

        for(int i = 0; i < pokemons.size(); ++i) {
            Assertions.assertEquals(String.valueOf(((Pokemon)pokemons.get(i)).getId()), modeloAtualizado.getValueAt(i, 0));
            Assertions.assertEquals(((Pokemon)pokemons.get(i)).getName(), modeloAtualizado.getValueAt(i, 1));
            Assertions.assertEquals(((Pokemon)pokemons.get(i)).getType1(), modeloAtualizado.getValueAt(i, 2));
            Assertions.assertEquals(((Pokemon)pokemons.get(i)).getType2(), modeloAtualizado.getValueAt(i, 3));
        }

    }

    @Test
    public void testPesquisarPokemons() {
        this.janelaPrincipal.atualizarTabelaPokemon(this.pokemons);
        ArrayList<Pokemon> pokemons = this.janelaPrincipal.pesquisarPokemons("Bul");
        Assertions.assertEquals(1, ((Pokemon)pokemons.get(0)).getId());
        Assertions.assertEquals("Bulbasaur", ((Pokemon)pokemons.get(0)).getName());
        Assertions.assertEquals("Grass", ((Pokemon)pokemons.get(0)).getType1());
        Assertions.assertEquals("Poison", ((Pokemon)pokemons.get(0)).getType2());
    }

    @Test
    public void testFiltrarPokemons() {
        ArrayList<Pokemon> pokemons = this.janelaPrincipal.filtrarPokemons();
        Assertions.assertEquals(1, pokemons.size());
        Assertions.assertEquals(15, ((Pokemon)pokemons.get(1)).getId());
        Assertions.assertEquals("Beedril", ((Pokemon)pokemons.get(1)).getName());
        Assertions.assertEquals("Bug", ((Pokemon)pokemons.get(1)).getType1());
        Assertions.assertEquals("Poison", ((Pokemon)pokemons.get(1)).getType2());
    }
}
