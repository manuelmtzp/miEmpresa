jQuery(document).ready(function () {
	var demoJasper = function(){
		
	var inicio=new Date();
	inicio=inicio.getTime();
	
    alert("Entro js");	
   
    jQuery.ajax({
    	'async':false, 
    	'type': 'GET',
        'cache': false,
        'url': 'http://localhost:8080/EasyAlea_Core/rest/ImprimePdfsService/imprimeJasper',
        'contentType': 'application/json',
        'success': function(response)
        {
            try {
                alert('data  '+response);	

			} catch (e) {
				alert(e);
			}


        },
        'error': function(e){
        alert('Entra error ');	
        url = e.responseText;
       	url = 'file:///Users/domonrro/Documents/Pruebas Ireport/iReport 3.7.2/Reportes Generados Data Sourse/reporteJasper.pdf'; 
        alert('antes:'+url);
        	   window.open(url,'_blank');
        	}
    });

    
    alert("Salio tiempo : ");
    
    
      var fin=new Date();
        fin=fin.getTime();
        tiempo=(fin-inicio)/1000; 
        jQuery("#tiempoJ").val(tiempo);
    		  
	};
	
	var demoXdoc = function(){
		
    
    var inicio=new Date();
	inicio=inicio.getTime();
	
    alert("Entro js");	
   
    window.open("patronees.pdf", '_blank');
    
    alert("Salio tiempo : ");
    
    
      var fin=new Date();
        fin=fin.getTime();
        tiempo=(fin-inicio)/1000; 
        jQuery("#tiempoX").val(tiempo);
    		  
	};
		
	var demoItext = function(){
		
	var inicio=new Date();
	inicio=inicio.getTime();
	
    alert("Entro js");	
   
    window.open("patronees.pdf", '_blank');
    
    alert("Salio tiempo : ");
    
    
      var fin=new Date();
        fin=fin.getTime();
        tiempo=(fin-inicio)/1000;
        jQuery("#tiempoI").val(tiempo);
	};
		
	
	
	jQuery("#jasperD").on('click',demoJasper);
	jQuery("#xDoc").on('click',demoXdoc);
	jQuery("#iText").on('click',demoItext);
});
