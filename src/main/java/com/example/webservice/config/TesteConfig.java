package com.example.webservice.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.webservice.model.Categoria;
import com.example.webservice.model.Pedido;
import com.example.webservice.model.Produto;
import com.example.webservice.model.User;
import com.example.webservice.model.enuns.PedidoStatus;
import com.example.webservice.repository.CategoriaRepository;
import com.example.webservice.repository.PedidoRepository;
import com.example.webservice.repository.ProdutoRepository;
import com.example.webservice.repository.UserRepository;

@Configuration
@Profile("test") //tem que ser igualzinho que tem la no profile do application.properties
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	//tudo vai ser executado quando a aplicação for executada
	@Override
	public void run(String... args) throws Exception {
		
		
		Categoria c1 = new Categoria(null, "Eletrônicos");
		Categoria c2 = new Categoria(null, "Gamers");
		
		Produto p1 = new Produto(null, "Drone", "Phantom 4", 1.5, "");
		Produto p2 = new Produto(null, "Video Game", "PS4", 100.2, "");
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2));
		produtoRepository.saveAll(Arrays.asList(p1, p2));
		
		//associação, adicionei no produto p1 a categoria para ele
		p1.getCategorias().add(c1);
		p2.getCategorias().add(c2);
		
		produtoRepository.saveAll(Arrays.asList(p1, p2));
		
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2)); //O comando salva uma lista
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.ESPERANDO_PAGAMENTO, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.ENTREGUE, u1); 
		
		pedidoRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		
		
	
		
		
	}
	
}
