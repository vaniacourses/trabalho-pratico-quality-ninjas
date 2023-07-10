package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pitest.mutationtest.engine.gregor.config.Mutator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static model.InOut.escreverArquivo;
import static model.InOut.lerArquivo;

public class InOutTest {

    @Test
    public void testLerArquivo() {
        File file = new File("data/test_files/pokemon_data_test");
        String conteudoEsperado = "1,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False,7,6";

        String conteudo = InOut.lerArquivo(file);

        conteudoEsperado = conteudoEsperado.trim();
        conteudo = conteudo.trim();

        Assertions.assertEquals(conteudoEsperado, conteudo);
    }

    @Test
    public void testEscreverArquivo() throws IOException {
        String conteudo = "1;Apollo;Pallet";
        String nomeArquivo = "/data/treinadores.txt";

        escreverArquivo(conteudo, nomeArquivo);

        File arquivo = new File("C:/Users/Amanda/IdeaProjects/pokedex-master/data/treinadores.txt");
        Assertions.assertTrue(arquivo.exists());

        String conteudoEsperado = lerArquivo(arquivo);
        conteudoEsperado = conteudoEsperado.trim();

        Assertions.assertEquals(conteudoEsperado, conteudo);

        List<String> linhas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        }

        linhas.remove(conteudo);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (String linha : linhas) {
                writer.write(linha);
                writer.newLine();
            }
        }
    }

    @Test
    public void testImportarDadosTreinadores() {
        ArrayList<Treinador> treinadoresEsperados = new ArrayList<>();

        treinadoresEsperados.add(new Treinador(1, "Apollo", "Pallet"));

        ArrayList<Treinador> treinadores = InOut.importarDadosTreinadores();

        Assertions.assertEquals(treinadoresEsperados.get(0).getNome(), treinadores.get(0).getNome());
        Assertions.assertEquals(treinadoresEsperados.get(0).getRegiao(), treinadores.get(0).getRegiao());
    }

    @Test
    public void testImportarDadosPokemon() throws IOException {
        String nomeArquivo = "pokemons_test.txt";
        String caminhoArquivo = new File("").getAbsolutePath() + "\\" + nomeArquivo;

        String conteudoArquivo =
                "id,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary,Height,Weight\n" +
                "1,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False,7,6\n";

        escreverArquivoDeTeste(conteudoArquivo, nomeArquivo);

        ArrayList<model.Pokemon> pokemons = InOut.importarDadosPokemon(nomeArquivo);

        Assertions.assertFalse(pokemons.isEmpty());

        Assertions.assertEquals(1, pokemons.size());

        model.Pokemon pokemon1 = pokemons.get(0);
        Assertions.assertEquals(1, pokemon1.getId());
        Assertions.assertEquals("Bulbasaur", pokemon1.getName());
        Assertions.assertEquals("Grass", pokemon1.getType1());
        Assertions.assertEquals("Poison", pokemon1.getType2());
        Assertions.assertEquals(318, pokemon1.getTotal());
        Assertions.assertEquals(45, pokemon1.getHp());
        Assertions.assertEquals(49, pokemon1.getAttack());
        Assertions.assertEquals(49, pokemon1.getDefense());
        Assertions.assertEquals(65, pokemon1.getAtk());
        Assertions.assertEquals(65, pokemon1.getSpDef());
        Assertions.assertEquals(45, pokemon1.getSpeed());
        Assertions.assertEquals(1, pokemon1.getGeneration());
        Assertions.assertFalse(pokemon1.isLegendary());
        Assertions.assertEquals(7.0f, pokemon1.getHeight());
        Assertions.assertEquals(6.0f, pokemon1.getWeight());

        deletarArquivo(caminhoArquivo);
    }

    @Test
    public void testImportarDadosPokemonDeTreinador() throws IOException {
        String nomeArquivo = "pokemon_de_treinador_test.txt";
        String caminhoArquivo = new File("").getAbsolutePath() + "\\" + nomeArquivo;

        String conteudoArquivo = "1,1,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False,7,6\n" +
                "2,2,Charmander,Fire,,309,39,52,43,60,50,65,1,False,6,85\n" +
                "3,3,Squirtle,Water,,314,44,48,65,50,64,43,1,False,5,90\n";

        escreverArquivoDeTeste(conteudoArquivo, nomeArquivo);

        ArrayList<model.PokemonDeTreinador> pokemonsDeTreinador = InOut.importarDadosPokemonDeTreinador(nomeArquivo);

        Assertions.assertFalse(pokemonsDeTreinador.isEmpty());

        Assertions.assertEquals(3, pokemonsDeTreinador.size());

        model.PokemonDeTreinador pokemonDeTreinador1 = pokemonsDeTreinador.get(0);
        Assertions.assertEquals(1, pokemonDeTreinador1.getId());
        Assertions.assertEquals(1, pokemonDeTreinador1.getIdTreinador());
        Assertions.assertEquals("Bulbasaur", pokemonDeTreinador1.getName());
        Assertions.assertEquals("Grass", pokemonDeTreinador1.getType1());
        Assertions.assertEquals("Poison", pokemonDeTreinador1.getType2());
        Assertions.assertEquals(318, pokemonDeTreinador1.getTotal());
        Assertions.assertEquals(45, pokemonDeTreinador1.getHp());
        Assertions.assertEquals(49, pokemonDeTreinador1.getAttack());
        Assertions.assertEquals(49, pokemonDeTreinador1.getDefense());
        Assertions.assertEquals(65, pokemonDeTreinador1.getAtk());
        Assertions.assertEquals(65, pokemonDeTreinador1.getSpDef());
        Assertions.assertEquals(45, pokemonDeTreinador1.getSpeed());
        Assertions.assertEquals(1, pokemonDeTreinador1.getGeneration());
        Assertions.assertFalse(pokemonDeTreinador1.isLegendary());
        Assertions.assertEquals(7.0f, pokemonDeTreinador1.getHeight());
        Assertions.assertEquals(6.0f, pokemonDeTreinador1.getWeight());

        deletarArquivo(caminhoArquivo);
    }

    @Test
    public void testConverter() {

        boolean resultado = InOut.converter("true");

        Assertions.assertTrue(resultado);
    }

    private void escreverArquivoDeTeste(String conteudo, String caminhoArquivo) throws IOException {
        FileWriter fw = null;
        try {
            fw = new FileWriter(caminhoArquivo);
            fw.write(conteudo);
        } finally {
            if (fw != null) {
                fw.close();
            }
        }
    }

    private void deletarArquivo(String caminhoArquivo) {
        File arquivo = new File(caminhoArquivo);
        arquivo.delete();
    }


}






