public class ProjetosDePesquisa {
    private String titulo;
    private String equipeResponsavel;
    private double duracaoEstimada;
    private String requisitosDeEquipamentos;
    private String status = "nao tem";

    public ProjetosDePesquisa(String titulo, String equipeResponsavel, double duracaoEstimada,String requisitosDeEquipamentos, String status) {
        this.titulo = titulo;
        this.equipeResponsavel = equipeResponsavel;
        this.duracaoEstimada = duracaoEstimada;
        this.requisitosDeEquipamentos = requisitosDeEquipamentos;
        this.status = status;
    }

    public ProjetosDePesquisa() {
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getEquipeResponsavel() {
        return equipeResponsavel;
    }
    public void setEquipeResponsavel(String equipeResponsavel) {
        this.equipeResponsavel = equipeResponsavel;
    }
    public double getDuracaoEstimada() {
        return duracaoEstimada;
    }
    public void setDuracaoEstimada(double duracaoEstimada) {
        this.duracaoEstimada = duracaoEstimada;
    }
    public String getRequisitosDeEquipamentos() {
        return requisitosDeEquipamentos;
    }
    public void setRequisitosDeEquipamentos(String requisitosDeEquipamentos) {
        this.requisitosDeEquipamentos = requisitosDeEquipamentos;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    
}
