package promocao;

import rh.Cargo;
import rh.Funcionario;
import rh.exception.ValidacaoException;

public class PromocaoService {
    public void promover(Funcionario funcionario, Boolean metaBatida){
        Cargo cargoAtual = funcionario.getCargo();

        if(Cargo.GERENTE == cargoAtual){
            throw new ValidacaoException("Gerentes não podem ser promovidos");
        }

        if(metaBatida){
            Cargo novoCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novoCargo);
        }
        else{
            throw new ValidacaoException("Funcionario não bateu a meta!");
        }


    }
}
