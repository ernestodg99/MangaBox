$(document).ready(function() {
    $('#favorito').click(function(event) {
        $('#favorito').hide();
        $('#nofavorito').show();
        var usuario = $('#usuario').val();
        var serie = $('#serie').val();
                   
        $.ajax({
            type:'POST',
            data: {
                usuario : usuario,
                serie: serie
            },
            url:'AddFavorito.htm',
            success: function(result){
                console.log("Correcto");
            }
        });
    });
                
    $('#nofavorito').click(function(event) {
        $('#nofavorito').hide();
        $('#favorito').show();
        var usuario = $('#usuario').val();
        var serie = $('#serie').val();
             
        $.ajax({
            type:'POST',
            data: {
                usuario : usuario,
                serie: serie
            },
            url:'EliminarFavorito.htm',
            success: function(result){
                console.log("Correcto");
            }
        });
    });
                    
    $('#favorito2').click(function(event) {
        $('#favorito2').hide();
        $('#nofavorito2').show();
        var usuario = $('#usuario').val();
        var serie = $('#serie').val();
                    
        $.ajax({
            type:'POST',
            data: {
                usuario : usuario,
                serie: serie
            },
            url:'AddFavorito.htm',
            success: function(result){
                console.log("Correcto");
            }
        });
    });
                
    $('#nofavorito2').click(function(event) {
        $('#nofavorito2').hide();
        $('#favorito2').show();
        var usuario = $('#usuario').val();
        var serie = $('#serie').val();
                 
        $.ajax({
            type:'POST',
            data: {
                usuario : usuario,
                serie: serie
            },
            url:'EliminarFavorito.htm',
            success: function(result){
                console.log("Correcto");
            }
        });
    });
});


