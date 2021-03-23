window.onload = function() {
    let main = document.querySelector('.main');
    console.log(main);

    let sub = main.getElementsByTagName('ul');
    console.log(sub);

    let mainMenu = main.getElementsByTagName('li');
    console.log(mainMenu);

    for(let i = 0; i < 4; i++) {
        mainMenu[i].addEventListener('mouseover', function() {
            sub[i].style.display = 'inline';
        });
        sub[i].addEventListener('mouseover', function() {
            sub[i].style.display = 'inline';
        });
        mainMenu[i].addEventListener('mouseout', function() {
            sub[i].style.display = 'none';
        });
        sub[i].addEventListener('mouseout', function() {
            sub[i].style.display = 'none';
        });
    }
}