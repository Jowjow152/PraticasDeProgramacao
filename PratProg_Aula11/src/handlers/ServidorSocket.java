
package handlers;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class ServidorSocket {

	private ServerSocket servidor;
	private ArrayList<ThreadCliente> clientes = new ArrayList<>();
	private JTextArea campoMensagens;
	private static ServidorSocket ss = null;
	
	private ServidorSocket() {
		
	}
	
	public synchronized static ServidorSocket getInstance() {
		if(ss == null) {
			ss = new ServidorSocket();
			return ss;
		}else {
			return ss;
		}
		
	}
	
	public void iniciar(String porta, JTextArea campoMensagens) throws IOException {
		this.campoMensagens = campoMensagens;
		servidor = new ServerSocket(Integer.parseInt(porta));
		String msg;


		while (true) {
			clientes.add(new ThreadCliente(servidor.accept(), clientes.size() + 1));
			msg = clientes.size() + " Entrou no chat" ;
			campoMensagens.append(msg + "\n");
			for(ThreadCliente cliente : clientes) {
				cliente.enviaMensagem(msg);
			}
			
		}

	}

	public void enviarMensagem(int remetente ,String mensagem) throws IOException {
		mensagem = remetente + ": " + mensagem;
		campoMensagens.append(mensagem + "\n");
		for(ThreadCliente cliente : clientes) {
			cliente.enviaMensagem(mensagem);
		}
	}

}
