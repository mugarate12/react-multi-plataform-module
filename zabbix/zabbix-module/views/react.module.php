<?php
$env = parse_ini_file(__DIR__ . '/../.env');
$iframe_url = $env['VITE_IFRAME_URL'] ?? 'http://localhost:3000';
?>

<html>
<iframe id="content" src="<?= htmlspecialchars($iframe_url) ?>" frameborder="0"></iframe>
<style>
  #content {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    border: none;
  }
</style>

</html>