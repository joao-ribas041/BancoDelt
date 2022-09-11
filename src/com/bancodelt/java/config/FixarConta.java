package com.bancodelt.java.config;

public class FixarConta {
    
    public String conta;
    private static final String format = "########-#";

    public FixarConta(String conta) {
        this.conta = this.formatarConta(conta, false);
        System.out.println("\n\n" + this.conta);
    }
    
    private String formatarConta(String c, boolean mascara){
        if(mascara) {
            return (c.substring(0, 8) + "-" + c.substring(8, 9));
        } else {
            c = c.replace("-", "");
            return c;
        }
    }
    
    public String tamanhoConta(){
        String conta = "";
        //logica para calcular tamanho de string
        return conta;
    }
    
    public String getConta(boolean masc) {
        return formatarConta(this.conta, masc);
    }
    
}
