package com.clinicaMedica.clinicaMedica.Enum;

public enum SimNao {

    S( 1),
    N( 0);


    private  final int id;

    SimNao(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public static SimNao fromId(Integer id) {

        for(SimNao simNao : values()) {
            if(simNao.getId() == id) {
                return simNao;
            }
        }
        throw new IllegalArgumentException("id não encontrado"+ id);
    }

}
