document.addEventListener("DOMContentLoaded", function () {

    let tempPlayer = document.querySelector("p#actPlayer");
    let playerName = document.getElementById("playerName");
    let oPlayerName = document.getElementById("oPlayerName").innerHTML;
    let xPlayerName = document.getElementById("xPlayerName").innerHTML;
    let gameId = document.getElementById("gameId").innerHTML;

    function switchPlayer() {
        let player = tempPlayer.innerHTML;
        if (player==1) {
            tempPlayer.innerHTML=0;
            playerName.innerHTML="Active player: "+ oPlayerName;
        } else {
            tempPlayer.innerHTML=1;
            playerName.innerHTML="Active player: "+ xPlayerName;
        }
    }

    // function colourChange () {
    //     let button = document.getElementsByName("button")
    //     if (this.innerHTML==1) {
    //         this.button.style.backgroundColor = "black";
    //     } else {
    //         this.button.style.backgroundColor = "white";
    //     }
    // }

    let findButton00 = document.getElementById("00")
    findButton00.addEventListener('click',function() {
        let player = tempPlayer.innerHTML;
        $.get("/rest/game/0/0/"+player+"/"+gameId, function (data, status) {
            findButton00.innerText = player;
            switchPlayer();
            findButton00.disabled = true;
        });
    });

    let findButton01 = document.getElementById("01")
    findButton01.addEventListener('click',function() {
        let player = tempPlayer.innerHTML;
        $.get("/rest/game/0/1/"+player+"/"+gameId, function (data, status) {
            findButton01.innerText = player;
            switchPlayer();
            findButton01.disabled = true;
        })
    });

    let findButton02 = document.getElementById("02")
    findButton02.addEventListener('click',function() {
        let player = tempPlayer.innerHTML;
        $.get("/rest/game/0/2/"+player+"/"+gameId, function (data, status) {
            findButton02.innerText = player;
            switchPlayer();
            findButton02.disabled = true;
        })
    });

    let findButton10 = document.getElementById("10")
    findButton10.addEventListener('click',function() {
        let player = tempPlayer.innerHTML;
        $.get("/rest/game/1/0/"+player+"/"+gameId, function (data, status) {
            findButton10.innerText = player;
            switchPlayer();
            findButton10.disabled = true;
        })
    });

    let findButton11 = document.getElementById("11")
    findButton11.addEventListener('click',function() {
        let player = tempPlayer.innerHTML;
        $.get("/rest/game/1/1/" + player + "/" + gameId, function (data, status) {
            findButton11.innerText = player;
            switchPlayer();
            findButton11.disabled = true;
        })
    });

    let findButton12 = document.getElementById("12")
    findButton12.addEventListener('click', function () {
        let player = tempPlayer.innerHTML;
        $.get("/rest/game/1/2/" + player + "/" + gameId, function (data, status) {
            findButton12.innerText = player;
            switchPlayer();
            findButton12.disabled = true;
        })
    });

    let findButton20 = document.getElementById("20")
    findButton20.addEventListener('click', function () {
        let player = tempPlayer.innerHTML;
        $.get("/rest/game/2/0/" + player + "/" + gameId, function (data, status) {
            findButton20.innerText = player;
            switchPlayer();
            findButton20.disabled = true;
        })
    });

    let findButton21 = document.getElementById("21")
    findButton21.addEventListener('click', function () {
        let player = tempPlayer.innerHTML;
        $.get("/rest/game/2/1/" + player + "/" + gameId, function (data, status) {
            findButton21.innerText = player;
            switchPlayer();
            findButton21.disabled = true;
        })
    });

    let findButton22 = document.getElementById("22")
    findButton22.addEventListener('click', function () {
        let player = tempPlayer.innerHTML;
        $.get("/rest/game/2/2/" + player + "/" + gameId, function (data, status) {
            findButton22.innerText = player;
            switchPlayer();
            findButton22.disabled = true;
        })
    });

})