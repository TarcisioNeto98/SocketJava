import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		try {
			ServerSocket servidor = new ServerSocket(2000);
			while(true) {
				Socket cliente = servidor.accept();//Utilizo um método accept do objeto servidor, ele aceita uma conecção
				//de algum cliente.
				
				
				DataInputStream canal_de_entrada = new DataInputStream(cliente.getInputStream());//DataInputStream classe
				//utilizada para pegar a conecção do socket de entrada do socket.
				DataOutputStream canal_de_saida = new DataOutputStream(cliente.getOutputStream());//DataOutputStream
				//classe utilizada para captar a conecção de saída do socket.
				String dado_enviado_do_cliente = canal_de_entrada.readUTF();//Método que capta a entrada do socket
				//readUTF() retorna uma String, existem outros métodos que podem retornar outros tipos de dados,
				//depende do valor enviado pelo cliente.
				
				canal_de_entrada.close();//Fecho o meu fluxo de entrada.
				canal_de_saida.close();//fecho o meu fluxo de saída.
				cliente.close();//Fecho a conecção como cliente, para que outras conecções sejam feitas.
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
