# (c) Copyright 2012  Hewlett-Packard Development Company, L.P. 

SUMMARY = "Open webOS Just Type daemon"
SECTION = "webos/base"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "libxml2 luna-service2 glib-2.0 cjson sqlite3 "

PR = "r6"

inherit webos_component
inherit webos_public_repo
inherit webos_enhanced_submissions
inherit webos_cmake
inherit webos_system_bus
inherit webos_daemon

WEBOS_GIT_TAG = "submissions/${WEBOS_SUBMISSION}"
SRC_URI = "${OPENWEBOS_GIT_REPO}/${PN};tag=${WEBOS_GIT_TAG};protocol=git"
S = "${WORKDIR}/git"

# TODO: Remove once there's localization support
do_install_append() {
        install -d ${D}${webos_prefix}/universalsearchmgr/resources/en_us
        install -v -m 0644 ${S}/desktop-support/UniversalSearchList.json ${D}${webos_prefix}/universalsearchmgr/resources/en_us
}


FILES_${PN} += "${webos_prefix}"
