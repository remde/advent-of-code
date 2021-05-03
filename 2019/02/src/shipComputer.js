const RESULT_INDEX = 0;
const SUM_OPERATION = 1;
const FIRST_OPERATOR_OFFSET = 1;
const SECOND_OPERATOR_OFFSET = 2;
const MULTIPLY_OPERATION = 2;
const RESULT_INDEX_OFFSET = 3;
const DEFAULT_POINTER_LEAP = 4;
const HALT_OPERATION = 99;

/**
 * @param {Number[]} originalInput input to be read
 * @return {function(): Number} - the returned function
 */
function restoreGravityAssistProgram(originalInput) {

    let input = [];

    const runProgram = () => {
        for (let i=0; i<input.length; i+=DEFAULT_POINTER_LEAP) {
            if (input[i] == SUM_OPERATION) {
                input[input[i+RESULT_INDEX_OFFSET]] = input[input[i+FIRST_OPERATOR_OFFSET]] + input[input[i+SECOND_OPERATOR_OFFSET]];
            }
            else if (input[i] == MULTIPLY_OPERATION) {
                input[input[i+3]] = input[input[i+FIRST_OPERATOR_OFFSET]] * input[input[i+SECOND_OPERATOR_OFFSET]];
            }
            else if (input[i] == HALT_OPERATION) {
                break;
            }
        }
    }

    const resetInput = () => {
        input = [...originalInput];
    }

    const setInitialPositions = (noun, verb) => {
        input[1] = noun;
        input[2] = verb;
    }

    const getResult = () => {
        return input[0];
    }

    /**
    * @param {Number} noun
    * @param {Number} verb
    * @return {Number}
    */
    return (noun, verb) => {
        resetInput();
        setInitialPositions(noun, verb);
        runProgram();
        return getResult();
    }
}


exports.restoreGravityAssistProgram = restoreGravityAssistProgram;
