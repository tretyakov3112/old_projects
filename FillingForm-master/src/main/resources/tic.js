function myfunc() {

    var b1, b2, b3, b4, b5, b6, b7, b8;
    b1 = document.getElementById("b1").value;
    b2 = document.getElementById("b2").value;
    b3 = document.getElementById("b3").value;
    b4 = document.getElementById("b4").value;
    b5 = document.getElementById("b5").value;
    b6 = document.getElementById("b6").value;
    b7 = document.getElementById("b7").value;
    b8 = document.getElementById("b8").value;

    arr = [b1, b2, b3, b4, b5, b6, b7, b8];


    function myfunc_2() {
        // location.reload();
        // for (let i = 0; i < 8; i++) {
        //     arr1[i] = '';
        // }
        b2.reset;



    }

    function stepPlayer(elementId) {
        let element = document.getElementById(elementId);
        element.disabled = true;
        myfunc();
    }
}