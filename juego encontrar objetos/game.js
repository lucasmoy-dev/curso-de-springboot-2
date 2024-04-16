

let objetosEncontrados = [];

function init() {
    let imgJuego = document.getElementById("imagen-juego");
    imgJuego.src = game.picture;
    imgJuego.addEventListener("click", onClickImgJuego);
    cargarListaDeObjetosAEncontrar();
}

function cargarListaDeObjetosAEncontrar() {
    let htmlLista = "";
    for (let i = 0; i < game.objects.length; i++) {
        let objetoActual = game.objects[i];

        let elObjetoYaFueEncontrado = objetosEncontrados.find(obj => obj == objetoActual);
        let name = objetoActual.name;
        if (elObjetoYaFueEncontrado) {
            name = "<del>" + objetoActual.name + "</del>";
        }

        if (htmlLista == "") {
            htmlLista = name;
        } else {
            htmlLista += ", " + name;
        }
    }
    let listaObjetos = document.getElementById("lista-objetos");
    listaObjetos.innerHTML = htmlLista;
}

function onClickImgJuego(event) {
    let imgJuego = document.getElementById("imagen-juego");
    let rect = imgJuego.getBoundingClientRect();
    let clickX = event.clientX - rect.left;
    let clickY = event.clientY - rect.top;
    //alert("X:" + posX + " " + "posY:" + posY)

    let objetoEncontrado = encontroUnObjeto(clickX, clickY);
    if (objetoEncontrado == null) {
        alert("No encontraste nada");
    } else {
        alert("Encontraste: " + objetoEncontrado.name);
        objetosEncontrados.push(objetoEncontrado);
        cargarListaDeObjetosAEncontrar();
    }
}

function encontroUnObjeto(clickX, clickY) {
    for (let i = 0; i < game.objects.length; i++) {
        let objetoActual = game.objects[i];
        let estaDentroDelRangoX = objetoActual.initX < clickX 
                                    && clickX < objetoActual.endX;
        let estaDentroDelRangoY = objetoActual.initY < clickY 
                                    && clickY < objetoActual.endY;

        if(estaDentroDelRangoX && estaDentroDelRangoY) {
            return objetoActual;
        }
    }
    return null;
}

init();