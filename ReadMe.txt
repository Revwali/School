#project debreif


# Next update


# add fetching by phone/aadhar instead of id -> added fetching with basic details as of now
# Security update: option1: There wil be no different scopes for one user to determine for full or partial DTO,
#                            instead there will be a key with every user which will help fecth full details
#                   option2: There will different scopes for a user and will get activated accordinlgy to their
#                           login, basic for just login and key/two-factor auth will activate full access
# option 2 will be given priority as two-factor will be more secured over carrying key in headers.