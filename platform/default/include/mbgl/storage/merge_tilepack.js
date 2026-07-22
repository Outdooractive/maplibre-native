var fs = require('fs');
fs.writeFileSync('platform/default/include/mbgl/storage/merge_tilepack.hpp', `#pragma once

// THIS IS A GENERATED FILE; EDIT merge_tilepack.sql INSTEAD
// To regenerate, run \`node platform/default/include/mbgl/storage/merge_tilepack.js\`

namespace mbgl {

static constexpr const char* mergeTilepackDatabaseSQL =
${fs.readFileSync('platform/default/include/mbgl/storage/merge_tilepack.sql', 'utf8')
    .replace(/ *--.*/g, '')
    .split('\n')
    .filter(a => a)
    .map(line => '"' + line + '\\n"')
    .join('\n')
}
;

} // namespace mbgl
`);

