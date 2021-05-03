const fs = require('fs')
const getInputAsArray = (filename) => fs.readFileSync(filename, 'utf-8')
                .trim()
                .split(',');

exports.getInputAsArray = getInputAsArray;
