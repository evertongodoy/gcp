package br.senac.sp.gcp.usecase.impl;

import br.senac.sp.gcp.usecase.RecuperaInstituicao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretVersionName;

@RequiredArgsConstructor
@Service
public class ReuperaInstituicaoImpl implements RecuperaInstituicao {

    @Override
    public String recuperarInstituicao(String projectId, String secretId) {
        return recuperarInstituicao(projectId, secretId, "latest");
    }

    @Override
    public String recuperarInstituicao(String projectId, String secretId, String version) {
        SecretVersionName name = SecretVersionName.of(projectId, secretId, version);
        try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
            AccessSecretVersionResponse res = client.accessSecretVersion(name);
            return res.getPayload().getData().toStringUtf8();
        } catch (Exception e) {
            throw new RuntimeException("Falha ao acessar secret " + secretId, e);
        }
    }

}
