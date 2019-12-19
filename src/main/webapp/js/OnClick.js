document.addEventListener("DOMContentLoaded", function () {

    var buttonParams = {
        "playerId" : 1,
        "mark" : "O",
        "x" : 8,
        "y" : 2
    }

    let tempPlayer = document.querySelector("p#actPlayer");
    let player = tempPlayer.innerHTML;

    let findButton00 = document.getElementById("00")
    findButton00.addEventListener('click',function() {
        $.get("/rest/game/0/0/"+player, function (data, status) {
            findButton00.innerText=player;
        })
    });

    let findButton01 = document.getElementById("01")
    findButton01.addEventListener('click',function() {
        $.get("/rest/game/0/1/"+player)
    });

    let findButton02 = document.getElementById("02")
    findButton02.addEventListener('click',function() {
        $.get("/rest/game/0/2/"+player)
    });

    let findButton10 = document.getElementById("10")
    findButton10.addEventListener('click',function() {
        $.get("/rest/game/1/0/"+player)
    });

    let findButton11 = document.getElementById("11")
    findButton11.addEventListener('click',function() {
        $.get("/rest/game/1/1/"+player)
    });

    let findButton12 = document.getElementById("12")
    findButton12.addEventListener('click',function() {
        $.get("/rest/game/1/2/"+player)
    });

    let findButton20 = document.getElementById("20")
    findButton20.addEventListener('click',function() {
        $.get("/rest/game/2/0/"+player)
    });

    let findButton21 = document.getElementById("21")
    findButton21.addEventListener('click',function() {
        $.get("/rest/game/2/1/"+player)
    });

    let findButton22 = document.getElementById("22")
    findButton22.addEventListener('click',function() {
        $.get("/rest/game/2/2/"+player)
    });

})