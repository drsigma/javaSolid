package service;

import rh.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {
    private List<ValidacaoReajuste> validacoes;

    public ReajusteService(List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalario(Funcionario funcionario, BigDecimal aumento) {
        //jeito certo ao aplicar OCP já havia sido aplicado o DIP
        this.validacoes.forEach(v -> v.validar(funcionario, aumento));

        //jeito errado ao aplicar OCP já havia sido aplicado DIP
        ValidacaoPercentualReajuste validacaoPercentualReajuste = new ValidacaoPercentualReajuste();
        ValidacaoPeriodicidadeEntreReajuste validacaoPeriodicidadeEntreReajuste = new ValidacaoPeriodicidadeEntreReajuste();

        validacaoPercentualReajuste.validar(funcionario, aumento);
        validacaoPeriodicidadeEntreReajuste.validar(funcionario, aumento);
        //Ao se aplicar o OCP automaticamente já se aplicou o DIP

        BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
        funcionario.atualizaSalario(salarioReajustado);

    }
}
