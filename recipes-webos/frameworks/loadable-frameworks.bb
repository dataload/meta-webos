# (c) Copyright 2012  Hewlett-Packard Development Company, L.P.

SUMMARY = "Loadable frameworks component for the core applications"
SECTION = "webos/frameworks"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

PR = "r4"

#inherit webos_component
inherit webos_public_repo
inherit webos_submissions
#inherit webos_cmake
inherit webos_arch_indep

WEBOS_GIT_TAG = "${WEBOS_SUBMISSION}"
SRC_URI = "${OPENWEBOS_GIT_REPO}/${PN};tag=${WEBOS_GIT_TAG};protocol=git"
S = "${WORKDIR}/git"

do_install() {
        install -d ${D}${webos_frameworksdir}

        for FRAMEWORK in `ls -d1 ${S}/calendar* ${S}/contacts* ${S}/globalization` ; do
            FRAMEWORK_DIR=`basename $FRAMEWORK`
            install -d ${D}${webos_frameworksdir}/$FRAMEWORK_DIR/version/1.0/
            cp -vrf $FRAMEWORK/* ${D}${webos_frameworksdir}/$FRAMEWORK_DIR/version/1.0/
            # remove test and jasminetest dirs
            rm -vrf ${D}${webos_frameworksdir}/$FRAMEWORK_DIR/version/1.0/*test
        done
}

FILES_${PN} += "${webos_frameworksdir}"
