public class Usuario {
    private int id;
    private String nome;

    @Override
    public String toString() {
        return id + " - " + nome;
    }
    public Usuario(int id,String nome){
        this.id=id;
        this.nome=nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setId(int id) {
        this.id = id;
    }
}


