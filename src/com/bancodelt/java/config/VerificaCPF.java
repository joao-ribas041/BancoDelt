package com.bancodelt.java.config;

public class VerificaCPF {

    private String cpf;
    private static final String format = "###.###.###-##";

    public VerificaCPF(String cpf) {
        this.cpf = this.formatoMascara(cpf, false);
    }

    public boolean isCPF() {
        if (this.cpf.equals("00000000000")
                || this.cpf.equals("11111111111")
                || this.cpf.equals("22222222222")
                || this.cpf.equals("33333333333")
                || this.cpf.equals("44444444444")
                || this.cpf.equals("55555555555")
                || this.cpf.equals("66666666666")
                || this.cpf.equals("77777777777")
                || this.cpf.equals("88888888888")
                || this.cpf.equals("99999999999")
                || this.cpf.length() != 11) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;
        try {
            // Calculo do primeiro Digito Verificador 
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (this.cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }

            // Calculo do segundo Digito Verificador 
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (this.cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            if ((dig10 == this.cpf.charAt(9)) && (dig11 == this.cpf.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (Exception e) {
            return (false);
        }
    }

    private String formatoMascara(String cpf, boolean mascara) {
        if (mascara) {
            return (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "."
                    + cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
        } else {
            cpf = cpf.replace(".", "");
            cpf = cpf.replace("-", "");
            return cpf;
        }
    }

    public String getCpf(boolean masc) {
        return formatoMascara(this.cpf, masc);
    }

}
