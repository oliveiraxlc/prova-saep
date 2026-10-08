package com.treino.senai.models;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name="agendamento")
public class Agendamento {
    
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="data_atendimento")
    private Date data_atendimento;

    @Column(name="hora_atendimento")  
    private Time hora_atendimento;

    @OneToOne 
    @JoinColumn(name="crianca_id")
    private Crianca crianca;

    @OneToOne 
    @JoinColumn(name="psicologo_id")
    private Psicologo psicologo;

    public Agendamento() {
    }

    public Agendamento(Long id, Date data_atendimento, Time hora_atendimento, Crianca crianca, Psicologo psicologo) {
        this.id = id;
        this.data_atendimento = data_atendimento;
        this.hora_atendimento = hora_atendimento;
        this.crianca = crianca;
        this.psicologo = psicologo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData_atendimento() {
        return data_atendimento;
    }

    public void setData_atendimento(Date data_atendimento) {
        this.data_atendimento = data_atendimento;
    }

    public Time getHora_atendimento() {
        return hora_atendimento;
    }

    public void setHora_atendimento(Time hora_atendimento) {
        this.hora_atendimento = hora_atendimento;
    }

    public Crianca getCrianca() {
        return crianca;
    }

    public void setCrianca(Crianca crianca) {
        this.crianca = crianca;
    }

    public Psicologo getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Psicologo psicologo) {
        this.psicologo = psicologo;
    }

}
