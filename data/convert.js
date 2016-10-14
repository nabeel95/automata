var fs = require('fs');
var data = fs.readFileSync('./raw.json', 'utf8');
fs.writeFileSync('./final.json', JSON.parse(data));