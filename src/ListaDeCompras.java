import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.FileReader;
import java.lang.reflect.Type;



public class ListaDeCompras {
    private List<Item> itens = new ArrayList<>();

    public void adicionarItem(Item item){
        itens.add(item);
    }

    public void removerItem(String nome){
        itens.removeIf(item -> item.getNome().equalsIgnoreCase(nome));
    }

    public List<Item> getItens(){
        return itens;
    }

    public void listaItens(){
        if (itens.isEmpty()){
            System.out.println("A lista está vazia.");
        }else{
            for (int i=0; i<itens.size(); i++){
                System.out.println(itens.get(i));
            }
        }
    }

    public void salvarEmJson(){
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("lista.json")){
            gson.toJson(itens, writer);
            System.out.println("Lista salva com sucesso!");
        }catch (Exception e){
            System.out.println("Erro ao salvar em Json." + e.getMessage());
        }
    }
}
