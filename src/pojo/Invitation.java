/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Micka
 */
public class Invitation {
    
    private Evenement evenement;
    private Participant participant;

    public Invitation() {
    }

    public Invitation(Evenement evenement, Participant participant) {
        this.evenement = evenement;
        this.participant = participant;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    @Override
    public String toString() {
        return "Invitation{" + "evenement=" + evenement + ", participant=" + participant + '}';
    }

   
}
