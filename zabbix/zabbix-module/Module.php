<?php

namespace Modules\ReactModule;

use Zabbix\Core\CModule,
  APP,
  CMenu,
  CMenuItem;

class Module extends CModule
{
  public function init(): void
  {
    APP::Component()->get('menu.main')
      ->findOrAdd(_('Modulos'))
      ->getSubmenu()
      ->insertAfter(
        _('A'),
        (new CMenuItem(_('React')))->setAction('react.module')
      );
  }
}
