package view;

import model.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DetalhesPokemonTest {
    private DetalhesPokemon detalhesPokemon;

    @BeforeEach
    public void setUp() {
        Pokemon pokemon = new Pokemon(1, "Pikachu", "Electric", null, 300, 50, 60, 40, 50, 40, 90, 1, false, 0.4f, 6.0f);
        detalhesPokemon = new DetalhesPokemon(null, pokemon);
    }

    @Test
    public void testExibir() {
        boolean result = detalhesPokemon.exibir();
        // Verificar se o método retorna um booleano
        assertNotNull(result);
    }


    @Test
    public void testPreencher() {
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", "Grass", "Poison", 318, 45, 49, 49, 65, 65, 45, 1, false, 0.7f, 6.9f);
        Pokemon pokemon2 = new Pokemon(144, "Articuno", "Ice", "Flying", 580, 90, 85, 100, 95, 125, 85, 1, true, 1.7f, 55.4f);
        Pokemon pokemon3 = new Pokemon(145, "Zapdos", "Electric", "Flying", 580, 90, 90, 85, 125, 90, 100, 1, true, 1.6f, 52.6f);

        detalhesPokemon.preencher(pokemon1);

        // Verificar se os campos foram preenchidos corretamente
        assertEquals("Bulbasaur", detalhesPokemon.jLabelName.getText());
        assertEquals("Grass", detalhesPokemon.jLabelT1.getText());
        assertEquals("Poison", detalhesPokemon.jLabeT2.getText());
        assertEquals("NORMAL", detalhesPokemon.jLabelLeg.getText());
        assertEquals("45", detalhesPokemon.jLabelHp.getText());

        detalhesPokemon.preencher(pokemon2);
        assertEquals("Articuno", detalhesPokemon.jLabelName.getText());
        assertEquals("Ice", detalhesPokemon.jLabelT1.getText());
        assertEquals("Flying", detalhesPokemon.jLabeT2.getText());
        assertEquals("LEGENDARY", detalhesPokemon.jLabelLeg.getText());
        assertEquals("90", detalhesPokemon.jLabelHp.getText());

        detalhesPokemon.preencher(pokemon3);
        assertEquals("Zapdos", detalhesPokemon.jLabelName.getText());
        assertEquals("Electric", detalhesPokemon.jLabelT1.getText());
        assertEquals("Flying", detalhesPokemon.jLabeT2.getText());
        assertEquals("LEGENDARY", detalhesPokemon.jLabelLeg.getText());
        assertEquals("90", detalhesPokemon.jLabelHp.getText());

    }
}
