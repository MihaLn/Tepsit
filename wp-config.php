<?php
/**
 * The base configuration for WordPress
 *
 * The wp-config.php creation script uses this file during the
 * installation. You don't have to use the web site, you can
 * copy this file to "wp-config.php" and fill in the values.
 *
 * This file contains the following configurations:
 *
 * * MySQL settings
 * * Secret keys
 * * Database table prefix
 * * ABSPATH
 *
 * @link https://codex.wordpress.org/Editing_wp-config.php
 *
 * @package WordPress
 */

// ** MySQL settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define( 'DB_NAME', 'gite' );

/** MySQL database username */
define( 'DB_USER', 'root' );

/** MySQL database password */
define( 'DB_PASSWORD', '' );

/** MySQL hostname */
define( 'DB_HOST', 'localhost' );

/** Database Charset to use in creating database tables. */
define( 'DB_CHARSET', 'utf8mb4' );

/** The Database Collate type. Don't change this if in doubt. */
define( 'DB_COLLATE', '' );

/**#@+
 * Authentication Unique Keys and Salts.
 *
 * Change these to different unique phrases!
 * You can generate these using the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}
 * You can change these at any point in time to invalidate all existing cookies. This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define( 'AUTH_KEY',         '/w.]QoL*k3Sjs}h/6;_B|sxSAc#N&eRby|JrVD~/V/R2}G8vxP$E2?0En%F!>Q]c' );
define( 'SECURE_AUTH_KEY',  '>>q2gN7}h1jI~|%vuz19_#Dfi6(+kG,52Zg|PG9s<[e76hL83Aa3P?J6fi`^+pmp' );
define( 'LOGGED_IN_KEY',    'q<]R^>N?FD>}f=:[8ikD%<;knzrazzB&-SB|*-FRh-)(**tM)jZ.W|<ea|t&2xGO' );
define( 'NONCE_KEY',        '^X[jtl)NEL,)vB%[V1O)xA|kh>A,4}W0%~lpxy-8Rn6c=8C:8tTo&M44q:9*fC~:' );
define( 'AUTH_SALT',        '+`%K#8sL-W mVmzHS.OMI=9<%wpD%q[/@yej?%[osuBKEhVb7xLNlHa4zN6:O05C' );
define( 'SECURE_AUTH_SALT', 'WAl:^%08!}3>LB^ +5pkx63v<]d|DZXm!=AMFd^}<I`U!7WDvVxWGS0Oyxt-_YB`' );
define( 'LOGGED_IN_SALT',   '8f>5cqwJ)jufs)d4?=VHX-V@wY2zGCTxtK]$ngx[X{Tf|1.W`PRmWN 5zQw&s Ds' );
define( 'NONCE_SALT',       'Vphe^?G6?v?Y1_jFD+lV*}L6S?NMCL]6.8R9_/JmGE} jD-$as;F]|/<-,L%TcX.' );

/**#@-*/

/**
 * WordPress Database Table prefix.
 *
 * You can have multiple installations in one database if you give each
 * a unique prefix. Only numbers, letters, and underscores please!
 */
$table_prefix = 'gite_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 *
 * For information on other constants that can be used for debugging,
 * visit the Codex.
 *
 * @link https://codex.wordpress.org/Debugging_in_WordPress
 */
define( 'WP_DEBUG', false );

/* That's all, stop editing! Happy publishing. */

/** Absolute path to the WordPress directory. */
if ( ! defined( 'ABSPATH' ) ) {
	define( 'ABSPATH', dirname( __FILE__ ) . '/' );
}

/** Sets up WordPress vars and included files. */
require_once( ABSPATH . 'wp-settings.php' );
