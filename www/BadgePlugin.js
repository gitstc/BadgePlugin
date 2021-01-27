function BadgePlugin() {
}

BadgePlugin.prototype.setBadgeNumber = function (badge, successCallback, errorCallback) {
    if (!badge) {
        badge = 0;
    }
    if ($.type(badge) !== "number") {
        try {
            badge = parseInt(badge);
        } catch (e) {
            badge = 0;
        }
    }
    if (badge > 99) {
        badge = 99;
    }
    cordova.exec(successCallback, errorCallback, "BadgePlugin", "setBadgeNumber", [badge]);
};

BadgePlugin.install = function () {
    if (!window.plugins) {
        window.plugins = {};
    }

    window.plugins.BadgePlugin = new BadgePlugin();

    return window.plugins.BadgePlugin;
};

cordova.addConstructor(BadgePlugin.install);