package br.ufsc.ine5608.rede;

//import javax.swing.JOptionPane;

import br.ufsc.ine5608.controller.GeneralController;
import br.ufsc.ine5608.controller.PlayerController;
import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

public class AtorNetgames implements OuvidorProxy {
	
	private static final long serialVersionUID = 1L;
	protected Proxy proxy;
	
	public AtorNetgames() {
            super();
            this.proxy = Proxy.getInstance();
            proxy.addOuvinte(this);	
	}
	
	public String conectar(String servidor, String nome) {
            try {
                    proxy.conectar(servidor, nome);
            } catch (JahConectadoException e) {
                    e.printStackTrace();
                    return "Voce ja esta conectado";
            } catch (NaoPossivelConectarException e) {
                    e.printStackTrace();
                    return "Nao foi possivel conectar";
            } catch (ArquivoMultiplayerException e) {
                    e.printStackTrace();
                    return "Voce esqueceu o arquivo de propriedades";
            }
            return "Sucesso: conectado a Netgames Server";
		
	}

	public String desconectar() {
            try {
                    proxy.desconectar();
            } catch (NaoConectadoException e) {
                    e.printStackTrace();
                    return "Voce nao esta conectado";
            }
            return "Sucesso: desconectado de Netgames Server";
	}

	public String iniciarPartida(String nomeJogador) {
            try {
                if(!temOponente(nomeJogador)){throw new Exception();}
                proxy.iniciarPartida(new Integer(2)); 
            } catch (NaoConectadoException e) {
                e.printStackTrace();
                return "Falha ao tentar enviar solicitacao de inicio enviada a Netgames Server";
            } catch (Exception e) {
                return "Falha ao tentar enviar solicitacao de inicio enviada a Netgames Server";
            }
            return "Sucesso: solicitacao de inicio enviada a Netgames Server";
	}
        
        public boolean temOponente(String nomeJogador){
            try {
                String nome1 = proxy.obterNomeAdversario(1);
                String nome2 = proxy.obterNomeAdversario(2);
                if(nome1.equals(nomeJogador)){
                    return nome2 != null && nome2.length() > 0;
                } else {
                    return nome1.length() > 0;
                }
            }catch (Exception e){
                return false;
            }
        }
        
        public String getNomeOponente(String nomeJogador) {
            try {
                String nome1 = proxy.obterNomeAdversario(1);
                String nome2 = proxy.obterNomeAdversario(2);
                if(nome1.equals(nomeJogador)){
                    return nome2;
                } else {
                    return nome1;
                }
            }catch (Exception e){
                return "";
            }
        }

	@Override
	public void iniciarNovaPartida(Integer posicao) {
            GeneralController.getInstance().startFrame();
	}

	@Override
	public void finalizarPartidaComErro(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receberMensagem(String msg) {
		// TODO Auto-generated method stub
	}

	@Override
	public void receberJogada(Jogada jogada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tratarConexaoPerdida() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		// TODO Auto-generated method stub
		
	}
	

}

