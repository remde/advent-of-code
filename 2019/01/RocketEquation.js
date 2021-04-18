const fs = require('fs')
const input = fs.readFileSync('input.txt', 'utf-8')
                .trim()
                .split('\n')

const getFuelFromMass = (mass) => Math.floor(parseInt(mass)/3) - 2;

const getModularFuel = (mass) => {
    let fuel = getFuelFromMass(mass)
    if (fuel > 0) return getModularFuel(fuel) + fuel
    return 0
}

// Part 1
const totalFuel = input.map(mass => getFuelFromMass(mass))
                  .reduce((a, b)=> a + b)
console.log(totalFuel)

// Part 2
const totalModularFuel = input.map(mass => getModularFuel(mass))
                       .reduce((a, b) => a + b)
console.log(totalModularFuel)
