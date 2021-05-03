const scanner = require('../scanner')
const shipComputer = require('./shipComputer')

const input = scanner.getInputAsArray("input.txt").map(Number);

const gravityRestorer = shipComputer.restoreGravityAssistProgram(input);

const printResultToFixProgram = () => console.log(gravityRestorer(12, 2));

const printVerbAndNounToMatch = (match) => {
    for (let noun=0; noun<100; noun++) {
        for (let verb=0; verb<100; verb++) {
            let result = gravityRestorer(noun, verb);
            if (result === match) {
                console.log(noun, verb);
                return;
            }
        }
    }
}

//Part 1
printResultToFixProgram();

//Part 2
printVerbAndNounToMatch(19690720);
