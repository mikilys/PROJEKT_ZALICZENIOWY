document.addEventListener("DOMContenetLoaded", function () {

    let findButton = document.querySelector("#button")

    findButton.addEventListener('click',function() {
        var buttonOnBoard = findButton.getAttribute("x");
        console.log(buttonOnBoard)
    });

})