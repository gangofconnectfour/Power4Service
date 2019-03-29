    create table public.auth (
       uuid varchar(255) not null,
        connected_at timestamp,
        expired_at timestamp,
        token varchar(255),
        primary key (uuid)
    );

    create table public.game (
       uuid varchar(255) not null,
        created_at timestamp,
        primary key (uuid)
    );

    create table public.multi_game (
       uuid varchar(255) not null,
        game_uuid varchar(255),
        score_logger_uuid varchar(255),
        primary key (uuid)
    );

    create table public.profile (
       uuid varchar(255) not null,
        level int4,
        nickname varchar(255),
        score float8,
        primary key (uuid)
    );

    create table public.score_logger (
       uuid varchar(255) not null,
        duration int8,
        nb_turn int4,
        winner_id varchar(255),
        primary key (uuid)
    );

    create table public.solo_game (
       uudi varchar(255) not null,
        ai_dificulty int4,
        game_uuid varchar(255),
        score_logger_uuid varchar(255),
        primary key (uudi)
    );

    create table public.user (
       uuid varchar(255) not null,
        create_at timestamp,
        email varchar(255),
        password varchar(255),
        update_at timestamp,
        profile_uuid varchar(255),
        primary key (uuid)
    );

    create table public.user_auths (
       user_uuid varchar(255) not null,
        auths_uuid varchar(255) not null
    );

    create table public.user_multi_games (
       user_uuid varchar(255) not null,
        multi_games_uuid varchar(255) not null
    );

    create table public.user_solo_games (
       user_uuid varchar(255) not null,
        solo_games_uudi varchar(255) not null);


    alter table if exists public.user_auths
       add constraint UK_321mves5b0qktny6v0k5s45dj unique (auths_uuid);

    alter table if exists public.user_multi_games
       add constraint UK_spiqivfugels1vmw0204xxv2p unique (multi_games_uuid);

    alter table if exists public.user_solo_games
       add constraint UK_93gu3qguwq2ssnp8le50w59hj unique (solo_games_uudi);

    alter table if exists public.multi_game
       add constraint FKecqqxoytsl7aowggu534l715
       foreign key (game_uuid)
       references public.game;

    alter table if exists public.multi_game
       add constraint FKm0orpvsuqao6s2m2me3kqyx2g
       foreign key (score_logger_uuid)
       references public.score_logger;

    alter table if exists public.solo_game
       add constraint FKlek61sopngxm70vcxpia1mh3x
       foreign key (game_uuid)
       references public.game;

    alter table if exists public.solo_game
       add constraint FK6m60nygh8ht1sjhhr35uqy7fm
       foreign key (score_logger_uuid)
       references public.score_logger;

    alter table if exists public.user
       add constraint FKqt07fq5h7woibnw0rarxlpv66
       foreign key (profile_uuid)
       references public.profile;

    alter table if exists public.user_auths
       add constraint FKsxpx26a2qb9ubjddgru1fq725
       foreign key (auths_uuid)
       references public.auth;

    alter table if exists public.user_auths
       add constraint FKhiox4t8qk8l9npbp4ktejcdym
       foreign key (user_uuid)
       references public.user;

    alter table if exists public.user_multi_games
       add constraint FKp9rq1qk8un93tx5sai5o3m8pb
       foreign key (multi_games_uuid)
       references public.multi_game;

    alter table if exists public.user_multi_games
       add constraint FKl0lpdpve0g6r0fun5lpfy4job
       foreign key (user_uuid)
       references public.user;

    alter table if exists public.user_solo_games
       add constraint FKqvnwx3omeiteusfl3s2ja9quo
       foreign key (solo_games_uudi)
       references public.solo_game;

    alter table if exists public.user_solo_games
       add constraint FKgmch3i36unsuo0lxu8mbx32g3
       foreign key (user_uuid)
       references public.user;