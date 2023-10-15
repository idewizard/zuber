package br.com.zuber.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    /*
    * Precisamos criar uma classe de configuração para deixar claro para o Spring
    * que ao tentar criar um novo model mapper, por exemplo quando colocamos a anotação
    * "@Autowired" acima do modelMapper nas nossas controlers, que o spring deve buscar aqui
    * pelo o que ele deve fazer para criar uma nova instancia daquele objeto    *
    * */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
