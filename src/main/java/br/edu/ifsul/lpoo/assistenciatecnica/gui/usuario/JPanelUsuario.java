/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package br.edu.ifsul.lpoo.assistenciatecnica.gui.usuario;

import br.edu.ifsul.lpoo.assistenciatecnica.Controle;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author telmo
 */
public class JPanelUsuario extends JPanel{
    
            private Controle controle;
            private CardLayout layoutCard;
    
            private JPanelListagem telaListagem;
            private JPanelFormulario telaFormulario;
            
            public JPanelUsuario(Controle controle){
        
                        this.controle = controle;
        
                        initComponents();
            }
            
                private void initComponents(){
        
                        layoutCard = new CardLayout();//inicializa o gerenciador de layout.
                        this.setLayout(layoutCard);//defini o gerenciador de layout para este painel.

                        telaListagem = new JPanelListagem(this, getControle());
                        telaFormulario = new JPanelFormulario(this, getControle());

                        this.add(getTelaListagem(), "tela_listagem"); // adiciona uma carta
                        this.add(getTelaFormulario(), "tela_edicao");     // adiciona a segunda carta no baralho.        

                        layoutCard.show(this, "tela_listagem"); //por padrão mostra o painel de listagem
           }
                
            public void showTela(String nomeTela){

                        if(nomeTela.equals("tela_edicao")){

                            getTelaFormulario().populaComboCidade();

                        }else if(nomeTela.equals("tela_listagem")){

                            telaListagem.populaTable();
                        }

                        layoutCard.show(this, nomeTela); 
            }    
                
            public JPanelFormulario getTelaFormulario() {
                        return telaFormulario;
            }
            
            public JPanelListagem getTelaListagem() {
                        return telaListagem;
            }  
            
            public Controle getControle() {
                  return controle;
            }    
    
}
