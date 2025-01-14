package it.iagica.learnig_rest.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.iagica.learnig_rest.entity.Article;
import it.iagica.learnig_rest.repository.ArticleRepository;

@Service
public class ArticleService<K, V> {
		
		//importo il repository
		@Autowired
		ArticleRepository articleRepository; 		
		
		@Autowired
		public ArticleService(ArticleRepository articleRepository) {
			
			this.articleRepository = articleRepository;
			
		}
		
		public Article saveArticolo(Article article) {			
			
			return (Article) articleRepository.save(article);
			
		}
		
		public List<Article> findAllArticolo(Article article) {
				
				return (List<Article>) articleRepository.findAll();
				
			}
		
		public Article findById(long id) {
			
			return  articleRepository.findById(id).orElse(null);
			
		}
		
		// update operation
	    
	    public Article updateArticolo(Article article, Long id) {
	    	
	    	//prendo l'articolo di ID id
	    	Article depDB = articleRepository.findById(id).get();
	    	
	    	//controllo se i parametri non sono nulli
	    	if (  (Objects.nonNull( article.getTitle()) && !("".equalsIgnoreCase(article.getTitle()) ) ) ){
	            depDB.setTitle(article.getTitle());
	        }
	        
	    	
	    	 if (  (Objects.nonNull( article.getCharacteristic()) ) && !("".equalsIgnoreCase(article.getCharacteristic() ) ) ) {
		            depDB.setCharacteristic(article.getCharacteristic());
		        }    	
	        
	        if (  (Objects.nonNull( article.getDescription()) && !("".equalsIgnoreCase(article.getDescription()) ) ) ){
	            depDB.setDescription(article.getDescription());
	        }	       
	        
	        if (  (Objects.nonNull( article.getQuantity()) ) ){
	            depDB.setQuantity(article.getQuantity());
	        }	              
	        
	        /*
	         * fare la verifica degli altri campi */
	        if (Objects.nonNull(article.getPrice()) ) {
	            depDB.setPrice( (Float) (article.getPrice()));
	        }
	       
	       
	        depDB.setDescription(article.getDescription());
	        depDB.setCode( article.getCode());    
	        
	        return (Article) articleRepository.save(depDB);
	    }

		public void deleteArticolo(Long id) {
			
			articleRepository.deleteById(id);
			
		}
		
		//metodo per convertire oggetto Map in Article
		public Article toEntity(Map<?, ?> params) {		
			
			String titolo = (String) params.get("title");
			String descrizione = (String) params.get("description");
			String caratteristiche = (String) params.get("characteristic");
			
			// valore != null e conversione String -> Integer
			String cat =   (!("").equals(params.get("category"))) ? (String) params.get("category") : "0";
			Integer categoria = Integer.parseInt(cat);
			
			// valore != null e conversione String -> Integer
			String quant =   (!("").equals(params.get("quantity"))) ? (String) params.get("quantity") : "0";
			Integer quantita = Integer.parseInt(quant);						
			
			/*
			String quant =  (String) params.get("quantity");
			Integer quantita = Integer.parseInt(quant);	
			*/	
			
			String prez =   (!("").equals(params.get("price"))) ? (String) params.get("price") : "0";
			Float prezzo = Float.parseFloat(prez);
			
			String unita =  (String) params.get("unity");
			
			String codice =  (String) params.get("code");
			
			String warehouse =   (!("").equals(params.get("warehouse"))) ? (String) params.get("warehouse") : "0";
			Long warehouseId =  Long.parseLong( warehouse ) ;
			
			Article art = new Article(titolo, descrizione, caratteristiche, categoria, quantita, unita, codice, prezzo, warehouseId);		
			
			return art;
			
		}
		

}


