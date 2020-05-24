$(document).ready(function() {
    $('#submit').click(function(event) {
        $('#nocomentarios').hide();
        var usuario = $('#usuario').val();
        var idcapitulo = $('#idcapitulo').val();
        var comentario = $('#comentario').val();
        $('#comentario').val('');           
        $.ajax({
            type:'POST',
            data: {
                usuario : usuario,
                idcapitulo: idcapitulo,
                comentario: comentario
            },
            url:'AddComentario.htm',
            success: function(result){
                $('#comentarios').html(result);
            }
        });
    });
});

