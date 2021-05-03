const shipComputer = require('../src/shipComputer');

const mockInput = [1,9,10,3,2,3,11,0,99,30,40,50];

test('Returns the result 5866714 for noun 12 and verb 2', () => {
    gravityRestorer = shipComputer.restoreGravityAssistProgram(mockInput);
    expect(gravityRestorer(9, 10)).toBe(3500);
});
