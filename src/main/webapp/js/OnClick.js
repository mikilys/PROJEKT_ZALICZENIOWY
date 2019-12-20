document.addEventListener("DOMContentLoaded", function () {

    let tempPlayer = document.querySelector("p#actPlayer");
    let player = tempPlayer.innerHTML;
    let gameId = document.getElementById("gameId").innerHTML;

    let findButton00 = document.getElementById("00")
    findButton00.addEventListener('click',function() {
        $.get("/rest/game/0/0/"+player+"/"+gameId, function (data, status) {
            findButton00.innerText=player;
            findButton00.innerText=gameId;
        // let x=$(this).data("x");
        // let y=$(this).data("y");
        // let move = {}
        // move.x = x;
        // move.y = y;
        // move.player = player;
        // $.ajax ({
        //     url: "/game/move/" + gameId,
        //     type: "POST",
        //     data: JSON.stringify(move),
        //     contentType: "application/json",
        });
            // findButton00.innerText=player;
    });

    let findButton01 = document.getElementById("01")
    findButton01.addEventListener('click',function() {
        $.get("/rest/game/0/1/"+player, function (data, status) {
            findButton01.innerText=player;
        })
    });

    let findButton02 = document.getElementById("02")
    findButton02.addEventListener('click',function() {
        $.get("/rest/game/0/2/"+player, function (data, status) {
            findButton02.innerText=player;
        })
    });

    let findButton10 = document.getElementById("10")
    findButton10.addEventListener('click',function() {
        $.get("/rest/game/1/0/"+player, function (data, status) {
            findButton10.innerText=player;
        })
    });

    let findButton11 = document.getElementById("11")
    findButton11.addEventListener('click',function() {
        $.get("/rest/game/1/1/"+player, function (data, status) {
            findButton11.innerText=player;
        })
    });

    let findButton12 = document.getElementById("12")
    findButton12.addEventListener('click',function() {
        $.get("/rest/game/1/2/"+player, function (data, status) {
            findButton12.innerText=player;
        })
    });

    let findButton20 = document.getElementById("20")
    findButton20.addEventListener('click',function() {
        $.get("/rest/game/2/0/"+player, function (data, status) {
            findButton20.innerText=player;
        })
    });

    let findButton21 = document.getElementById("21")
    findButton21.addEventListener('click',function() {
        $.get("/rest/game/2/1/"+player, function (data, status) {
            findButton21.innerText=player;
        })
    });

    let findButton22 = document.getElementById("22")
    findButton22.addEventListener('click',function() {
        $.get("/rest/game/2/2/"+player, function (data, status) {
            findButton22.innerText=player;
        })
    });

})