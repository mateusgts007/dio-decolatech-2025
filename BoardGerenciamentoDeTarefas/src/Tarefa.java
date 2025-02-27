public class Tarefa {
    private String titulo;
    private String descricao;
    private String status; // "A Fazer", "Em Progresso", "Concluído"

    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = "A Fazer"; // Status inicial
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return titulo + " - " + descricao + " (" + status + ")";
    }
}