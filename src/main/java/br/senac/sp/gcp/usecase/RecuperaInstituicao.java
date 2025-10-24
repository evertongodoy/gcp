package br.senac.sp.gcp.usecase;

public interface RecuperaInstituicao {

    public String recuperarInstituicao(String projectId, String secretId);
    public String recuperarInstituicao(String projectId, String secretId, String version);
}
