#project debreif
# add refresh in JWT security


# updated cors to match current requirements and csrf not needed in JWt stateless.
# update enities to extend Users -> User is being made normal POJO from Entity class and common - done
# properties will be assigned from this class and DB will be cleared for this table post checks - waiting
# UserDbCRUDRepositryService and TestOneEndpoint class is being commented as its of no use rn.  dpne
#
# Next update
# fix security using RBAC
#
#
#
# OTP integration
# Security update: user will have respective advanced scope in db but will only be activated
#                  when authenticated with OTP until then activate will be overiden with  BASIC